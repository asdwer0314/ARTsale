package ru.sfedu.api;

import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import ru.sfedu.model.*;
import ru.sfedu.model.enums.ProductType;
import ru.sfedu.utils.Result;

import java.util.List;
import java.util.Optional;

import static ru.sfedu.Constants.INPUT_ERROR;
import static ru.sfedu.model.enums.ProductType.MATERIAL;
import static ru.sfedu.model.enums.ProductType.WORKSPACE;

@BsonDiscriminator
public interface IDataProvider {






    //  User
    void delUserById(long id);
    Result <User> addUser(User object);
    Optional <User> getUserById(long id);
    Optional <User> upUserById(List<User> list, long id);

    //  Order
    void delOrderById(long id);
    Result <Order> addOrder(Order object);
    Optional <Order> getOrderById(long id);
    Optional <Order> upOrderById(List<Order> list, long id);

    //    Offer
    void delOfferById(long id);
    Result <Offer> addOffer(Offer object);
    Optional <Offer> getOfferById(long id);
    Optional <Offer> upOfferById(List<Offer> list, long id);

    //    Product
    void delProductById(long id);
    Result <Product> addProduct(Product object);
    Optional <Product> getProductById(long id);
    Optional <Product> upProductById(List<Product> list, long id);

    //    Workspace
    void delWorkspaceById(long id);
    Result <Workspace> addWorkspace(Workspace object);
    Optional <Workspace> getWorkspaceById(long id);
    Optional <Workspace> upWorkspaceById(List<Workspace> list, long id);

    //    Material
    void delMaterialById(long id);
    Result <Object> addMaterial(Material object);
    Optional <Material> getMaterialById(long id);
    Optional <Material> upMaterialById(List<Material> list, long id);



    /**
     * Gets product by type and id.
     *
     * @param prType the pType
     * @param id   the id
     * @return the product by type and id
     */
    default Optional<? extends Product> getProductByTypeAndId(ProductType prType, long id) {
        switch (prType) {
            case MATERIAL:
                return getMaterialById(id);
            case WORKSPACE:
                return getWorkspaceById(id);
            default:
                throw new IllegalStateException(INPUT_ERROR + prType);
        }
    }



//    public Result getRecordById(long id, Class class);
//    public Result delRecordById(long id, Class class);
//    public <T> Result addRecord(List<T> bean, Class class);
//    public <T> Result updRecordById(List<T> bean, long id, Class class);



}
