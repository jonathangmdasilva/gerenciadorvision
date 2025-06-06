package ia;

import java.io.BufferedReader;
import java.io.FileReader;
import weka.associations.Apriori;
import weka.core.Instances;

/*
 * @author Jonathan
 */

public class InteligenciaArtificial {
    
    public Apriori carregarApriori()throws Exception{        
        BufferedReader br;
        Apriori apriori;
        try ( // carregar dados (arquivo weka.arff) - configuração apriori
            FileReader fr = new FileReader("weka.arff")) {
            br = new BufferedReader(fr);
            Instances data = new Instances(br);
            apriori = new Apriori();
            apriori.setMinMetric(0.9);
            data.setClassIndex(data.numAttributes() - 1);
            apriori.setNumRules(4);
            apriori.buildAssociations(data);
        }
        br.close();        
        return apriori;
    }
        
    public String sugestao(String infs) throws Exception{
        String retorno ="";   
        int posUm = infs.indexOf('>');
        int posDois = infs.indexOf('(');        
        retorno = infs.substring(posUm+1, posDois-10);                        
        retorno = retorno.replace("_"," ");        
        retorno = retorno.replace("="," ");        
        return retorno;       
    }
}