package controller.administrativo;

import dao.administrativo.EmpresaDao;
import java.sql.SQLException;
import model.administrativo.EmpresaModel;

/*
 * @author Jonathan
 */

public class EmpresaController {
    
    
    public boolean validaEmpresa() throws SQLException, ClassNotFoundException{
        EmpresaDao empDao = new EmpresaDao();
        return empDao.validaEmpresa();
    }  
    
    public void inserirEmpresa(EmpresaModel empresa) throws SQLException, ClassNotFoundException{
        EmpresaDao empresaDao = new EmpresaDao();
        empresaDao.inserir(empresa);            
    }    
    
    public EmpresaModel consultaEmpresa() throws SQLException, ClassNotFoundException{
        EmpresaDao empresaDao = new EmpresaDao();
        return empresaDao.consultarEmpresa();            
    }    
}
