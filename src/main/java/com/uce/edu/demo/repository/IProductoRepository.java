package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Producto;

public interface IProductoRepository {

public void insertar(Producto producto);
	
	public void actulizar(Producto producto);
	
	public Producto buscarCodigoBarras(String codigoBarras);
	
	public Producto busquedaStockCodigo(String codigoBarras);
	
	public List<Producto> buscarTodos();
}
