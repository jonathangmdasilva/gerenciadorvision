package interfaces;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Jonathan
 * @param <T>
 */

//Interface responsável pelas classes Daos no qual todas devem implementar o CRUD padrão
public interface IDao<T> {    
    abstract void inserir(T instance)throws SQLException;
    abstract void alterar(T instance);
    abstract void excluir(Integer cod);
    abstract List<T> consultarTodos();
    abstract List<T> consultarCodigo(Integer cod);
    abstract List<T> consultarNome(String nome);        
}
