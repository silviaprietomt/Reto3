/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo3.Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admon
 */
@Service
public class ServiciosCategoria {
    @Autowired
    private RepositorioCategoria metodosCrud;
    
    public List<Categoria> getAll() {
        return metodosCrud.getAll();
    }
    
    public Optional<Categoria> getCategoria(int categoriaId) {
        return metodosCrud.getCategoria(categoriaId);
    }
    
      public Categoria save(Categoria categoria) {
       if (categoria.getId()==null) {
           return metodosCrud.save(categoria);
       }else{
           Optional<Categoria> categoria1=metodosCrud.getCategoria(categoria.getId());
           if (categoria1.isEmpty()){
               return metodosCrud.save(categoria);
           }else{
               return categoria;
           }
       }
    }
    
    public Categoria update(Categoria categoria){
        if(categoria.getId()!=null) {
            Optional<Categoria> g=metodosCrud.getCategoria(categoria.getId());
            if (g.isEmpty()){
                if(categoria.getDescription()!=null){
                    g.get().setDescription(categoria.getDescription());
                }
                if(categoria.getName()!=null){
                    g.get().setName(categoria.getName());                    
                }
                return metodosCrud.save(g.get());
            }else{
                return categoria;
            }        
        }else{
            return categoria; 
        }
    }

    boolean deleteCategoria(int categoriaId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
