package ru.sfedu.api;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.model.*;
import ru.sfedu.utils.Result;

import java.util.List;
import java.util.Optional;


public class DataProviderXML  implements IDataProvider {

    private static final Logger log = LogManager.getLogger(DataProviderXML.class);


    @Override
    public void delUserById(long id) {

    }

    @Override
    public Result<User> addUser(User object) {
        return null;
    }

    @Override
    public Optional<User> getUserById(long id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> upUserById(List<User> list, long id) {
        return Optional.empty();
    }

    @Override
    public void delOrderById(long id) {

    }

    @Override
    public Result<Order> addOrder(Order object) {
        return null;
    }

    @Override
    public Optional<Order> getOrderById(long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Order> upOrderById(List<Order> list, long id) {
        return Optional.empty();
    }

    @Override
    public void delOfferById(long id) {

    }

    @Override
    public Result<Offer> addOffer(Offer object) {
        return null;
    }

    @Override
    public Optional<Offer> getOfferById(long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Offer> upOfferById(List<Offer> list, long id) {
        return Optional.empty();
    }

    @Override
    public void delProductById(long id) {

    }

    @Override
    public Result<Product> addProduct(Product object) {
        return null;
    }

    @Override
    public Optional<Product> getProductById(long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Product> upProductById(List<Product> list, long id) {
        return Optional.empty();
    }

    @Override
    public void delWorkspaceById(long id) {

    }

    @Override
    public Result<Workspace> addWorkspace(Workspace object) {
        return null;
    }

    @Override
    public Optional<Workspace> getWorkspaceById(long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Workspace> upWorkspaceById(List<Workspace> list, long id) {
        return Optional.empty();
    }

    @Override
    public void delMaterialById(long id) {

    }

    @Override
    public Result<Object> addMaterial(Material object) {
        return null;
    }

    @Override
    public Optional<Material> getMaterialById(long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Material> upMaterialById(List<Material> list, long id) {
        return Optional.empty();
    }
}
