package jp.pokemonms.model.json.common;

import jp.pokemonms.model.constant.ElementType;

/**
 * めざめるパワー
 * 
 * @author sinmetal
 *
 */
public class AwakenPower {

    /** タイプ */
    private ElementType element;
    
    /** 威力 */
    private Integer edge;
    
    /**
     * インスタンス生成
     */
    public AwakenPower() {};
    
    /**
     * 初期値を設定
     * 
     * @param element タイプ
     * @param edge 威力
     */
    public AwakenPower(ElementType element, Integer edge) {
        this.element = element;
        this.edge = edge;
    }

    /**
     * @return the element
     */
    public ElementType getElement() {
        return element;
    }

    /**
     * @param element the element to set
     */
    public void setElement(ElementType element) {
        this.element = element;
    }

    /**
     * @return the edge
     */
    public Integer getEdge() {
        return edge;
    }

    /**
     * @param edge the edge to set
     */
    public void setEdge(Integer edge) {
        this.edge = edge;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((edge == null) ? 0 : edge.hashCode());
        result = prime * result + ((element == null) ? 0 : element.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AwakenPower other = (AwakenPower) obj;
        if (edge == null) {
            if (other.edge != null)
                return false;
        } else if (!edge.equals(other.edge))
            return false;
        if (element != other.element)
            return false;
        return true;
    }
    
}
