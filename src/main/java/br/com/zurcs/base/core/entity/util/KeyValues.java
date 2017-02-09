package br.com.zurcs.base.core.entity.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.zurcs.base.core.entity.util.KeyValue;

@XmlRootElement(name = "list")
public class KeyValues implements Serializable {

    private static final long serialVersionUID = 6303214997991197849L;
    
    private List<KeyValue> list = new ArrayList<KeyValue>();
    
    public KeyValues() {
        
    }
    
    public KeyValues(List<KeyValue> list) {
        this.list = list;
    }
    
    /**
     * 
     * Metodo de fabricação estatico para a classe KeyValues.
     * 
     * @param list
     *            - List<{@link KeyValue}> que será atribuida ao KeyValues
     * @return keyValues - uma instância de KeyValues com a lista estipulada.
     * 
     * 
     */
    public static KeyValues newKeyValuesWith(List<KeyValue> list){
        return new KeyValues(list);
    }

    @XmlElement(name = "item")
    public List<KeyValue> getList() {
        return list;
    }

}
