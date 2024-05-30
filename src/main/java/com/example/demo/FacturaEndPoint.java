package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.demo.BD.*;
import com.example.demo.Entidad.EmisorEntity;
import com.example.demo.Entidad.FacturaEntity;
import com.example.demo.Entidad.ProductoEntity;
import com.example.demo.Entidad.ReceptorEntity;

import mx.uv.t4is.factura.ConsultarFacturaRequest;
import mx.uv.t4is.factura.ConsultarFacturaResponse;
import mx.uv.t4is.factura.CrearFacturaRequest;
import mx.uv.t4is.factura.CrearFacturaResponse;
import mx.uv.t4is.factura.ConsultarFacturaResponse.Productos;
import mx.uv.t4is.factura.CrearFacturaRequest.Productos.Producto;

@Endpoint
public class FacturaEndPoint {

    @Autowired
    private IReceptor iReceptor;
    @Autowired
    private IEmisor iEmisor;
    @Autowired
    private IProducto iProducto;
    @Autowired
    private IFactura iFactura;

    @PayloadRoot(localPart = "CrearFacturaRequest", namespace = "t4is.uv.mx/factura")
    @ResponsePayload
    public CrearFacturaResponse crearFactura(@RequestPayload CrearFacturaRequest peticion) {
        CrearFacturaResponse respuesta = new CrearFacturaResponse();
        Date fecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        FacturaEntity factura = new FacturaEntity();
        factura.setId(UUID.randomUUID().toString());
        factura.setNumFactura(UUID.randomUUID().hashCode());
        formato.format(fecha);
        factura.setFechaEmision(formato.format(fecha));
        iFactura.save(factura);

        EmisorEntity emisor = new EmisorEntity();
        emisor.setId(UUID.randomUUID().toString());
        emisor.setNombre(peticion.getEmisor().getNombre());
        emisor.setRfc(peticion.getEmisor().getRFC());
        emisor.setRegimenFiscal(peticion.getEmisor().getRegimenFiscal());
        emisor.setIdFactura(factura.getId());
        iEmisor.save(emisor);

        ReceptorEntity receptor = new ReceptorEntity();
        receptor.setId(UUID.randomUUID().toString());
        receptor.setNombre(peticion.getReceptor().getNombre());
        receptor.setRfc(peticion.getReceptor().getRFC());
        receptor.setRegimenFiscal(peticion.getReceptor().getRegimenFiscal());
        receptor.setIdFactura(factura.getId());
        iReceptor.save(receptor);

        for(Producto producto : peticion.getProductos().getProducto()){
            ProductoEntity productoEntity = new ProductoEntity();
            productoEntity.setId(UUID.randomUUID().toString());
            productoEntity.setCantidad(String.valueOf(producto.getCantidad()));
            productoEntity.setPrecioUnitario(String.valueOf(producto.getPrecioUnitario()));
            productoEntity.setNombre(producto.getNombre());
            productoEntity.setIdFactura(factura.getId());
            iProducto.save(productoEntity);
        }

        respuesta.setMensaje("Se ha creado la factura - " + factura.getNumFactura() + " - exitosamente.");
        return respuesta;
    }

    @PayloadRoot(localPart = "ConsultarFacturaRequest", namespace = "t4is.uv.mx/factura")
    @ResponsePayload
    public ConsultarFacturaResponse consultarFactura(@RequestPayload ConsultarFacturaRequest peticion) {
        ConsultarFacturaResponse respuesta = new ConsultarFacturaResponse();
        String numFactura = peticion.getNumFactura();
        FacturaEntity factura = iFactura.findByNumFactura(Integer.parseInt(numFactura));
        if (factura != null) {
            List<ProductoEntity> listaP = iProducto.findByIdFactura(factura.getId().toString());
            for (ProductoEntity producto : listaP) {
                Productos pp = new Productos();
                pp.setNombre(producto.getNombre());
                pp.setPrecioUnitario(producto.getPrecioUnitario());
                pp.setCantidad(producto.getCantidad());
                respuesta.getProductos().add(pp);
            }
        }
        return respuesta;
    }
    
}