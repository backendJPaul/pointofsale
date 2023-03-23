package com.jpaul.pointofsale.model;

public class Category {
    private int idCategory;
    private String name;
    private int idCatalogStatus;

    public Category() {
    }

    public Category(int idCategory, String name, int idCatalogStatus) {
        this.idCategory = idCategory;
        this.name = name;
        this.idCatalogStatus = idCatalogStatus;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdCatalogStatus() {
        return idCatalogStatus;
    }

    public void setIdCatalogStatus(int idCatalogStatus) {
        this.idCatalogStatus = idCatalogStatus;
    }

    @Override
    public String toString() {
        return "Category{" +
                "idCategory=" + idCategory +
                ", name='" + name + '\'' +
                ", idCatalogStatus=" + idCatalogStatus +
                '}';
    }

}
