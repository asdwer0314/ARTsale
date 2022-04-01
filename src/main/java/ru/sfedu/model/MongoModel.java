package ru.sfedu.model;


import ru.sfedu.api.IDataProvider;

import java.util.List;
import java.util.Objects;

abstract public class MongoModel {

    private int _idProducts ;
    private String nameProducts;
    private String descriptionProducts;
    private List<IDataProvider> mirrorProducts;


    /**
     * Instantiates a new Order.
     * @param _idProducts
     * @param nameProducts
     * @param descriptionProducts
     */
    public MongoModel(long _idProducts,
                      String nameProducts,
                      String descriptionProducts,
                      String defaultConfigPath){
    }

    public int get_idProducts() {
        return _idProducts;
    }

    public void set_idProducts(int _id) {
        this._idProducts = _id;
    }

    public String getNameProducts() {
        return nameProducts;
    }

    public void setNameProducts(String nameProducts) {
        this.nameProducts = nameProducts;
    }

    public List<IDataProvider> getMirrorProducts() {
        return mirrorProducts;
    }

    public void setMirrorProducts(List<IDataProvider> mirrorProducts) {
        this.mirrorProducts = mirrorProducts;
    }

    public String getDescriptionProducts() {
        return descriptionProducts;
    }

    public void setDescriptionProducts(String descriptionProducts) {
        this.descriptionProducts = descriptionProducts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MongoModel)) return false;
        MongoModel mongoModel = (MongoModel) o;
        return _idProducts == mongoModel._idProducts
                && nameProducts.equals(mongoModel.nameProducts)
                && mirrorProducts.equals(mongoModel.mirrorProducts)
                && descriptionProducts.equals(mongoModel.descriptionProducts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_idProducts,
                nameProducts,
                mirrorProducts,
                descriptionProducts);
    }

    @Override
    public String toString() {
        return "MongoModel{" +
                "_id=" + _idProducts +
                ", name='" + nameProducts + '\'' +
                ", mirror=" + mirrorProducts +
                ", description='" + descriptionProducts + '\'' +
                '}';
    }
}
