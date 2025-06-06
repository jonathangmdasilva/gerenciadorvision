package model.administrativo;

/**
 * @author Jonathan
 */
public class ContatoModel {
   Integer idContato,idCliente,idFunc,idFornecedor,idEmpresa;
   String email,telUm,telDois;

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(Integer idFunc) {
        this.idFunc = idFunc;
    }

    public Integer getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

   
    public Integer getIdContato() {
        return idContato;
    }

    public void setIdContato(Integer idContato) {
        this.idContato = idContato;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelUm() {
        return telUm;
    }

    public void setTelUm(String telUm) {
        this.telUm = telUm;
    }

    public String getTelDois() {
        return telDois;
    }

    public void setTelDois(String telDois) {
        this.telDois = telDois;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

}
