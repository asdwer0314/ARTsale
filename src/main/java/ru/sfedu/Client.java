package ru.sfedu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.api.DataProviderCSV;
import ru.sfedu.api.DataProviderJDBC;
import ru.sfedu.api.DataProviderXML;
import ru.sfedu.api.IDataProvider;
import ru.sfedu.model.Material;
import ru.sfedu.model.Offer;
import ru.sfedu.model.User;
import ru.sfedu.model.Workspace;
import ru.sfedu.model.enums.ProductType;
//import ru.sfedu.utils.GenerateBean;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static java.lang.Long.parseLong;

public class Client {


    private static final Logger log = LogManager.getLogger(Client.class);


    public static void main(String[] args) {
        User userF = new User(1L, "address1", "+1000000", "true");
        User userS = new User(2L, "address2", "+2000000", "true");
        Material materialF = new Material(1L, "Mars", 200, new Date(), new Date(), 12, SNACKS);
        Material materialS =new Material(2L, "Snickers", 200, new Date(), new Date(), 12, SNACKS);
        Workspace drink1 = new Workspace (1L, "RedBull", 200, new Date(), new Date(), 11, WorkspaceType.EASELS);
        Workspace drink2 = new Workspace (2L, "Adrenaline", 200, new Date(), new Date(), 11, WorkspaceType.COASTERS);
        Offer offerF = new Offer (1L, "Vilka", 200, new Date(), new Date(), 11);
        Offer  offerS = new Offer (2L, "Tarelka", 200, new Date(), new Date(), 11);

        IDataProvider provider = initDataProvider(args[0]);
        provider.addUser(userF);
        provider.addUser(userS);
        provider.addMaterial(materialF);
        provider.addMaterial(materialS);
        provider.addWorkspace (drink1);
        provider.addWorkspace (drink2);
        provider.addOrder(1L,1L,1L, String.valueOf(ProductType.WORKSPACE));
        provider.addOrder(2L,2L,2L, String.valueOf(ProductType.MATERIAL));
        provider.addOffer (offerF);
        provider.addOrder (offerS);


        final String answer = useCase(provider, removeItem(args, 0));
        log.info(answer);
    }

    private static IDataProvider initDataProvider(String s) {
        switch (s.toUpperCase()) {
            case CLI_CSV:
                return new DataProviderCSV();
            case CLI_XML:
                return new DataProviderXML();
            case CLI_DB:
                return new DataProviderDB();
            default:
                throw new IllegalStateException("Unexpected value: " + s.toUpperCase());
        }
    }

    private static String useCase(IDataProvider provider, String[] s) {
        final String c = s[0];
        int i = 2;
        final String[] args = removeItem(s, 0);
        switch (c.toUpperCase()) {
            case CLI_GET:
                return getModel(provider, args[0], args[1]);
            case CLI_UPDATE:
                return updateModel(provider, args[0], removeItem(args, 0));
            case CLI_DELETE:
                return deleteModel(provider, args[0], args[1]);
            case SAVE_ORDER:
                i+=1;
                return provider.saveOrder(i,Long.parseLong(args[0]),Long.parseLong(args[1]),args[2]).getObject().toString();
            case GET_DISCOUNT:
                return provider.getDiscount(Long.parseLong(args[0])).toString();
            default:
                throw new IllegalStateException("Unexpected value: " + c.toUpperCase());
        }
    }

    private static String deleteModel(IDataProvider provider, String model, String id) {
        switch (model.toUpperCase()) {
            case CLI_ORDER:
                provider.deleteOrderById(parseLong(id)); break;
            case CLI_DRINK:
                provider.deleteDrinkById(parseLong(id)); break;
            case CLI_CUTLERY:
                provider.deleteCutleryById(parseLong(id)); break;
            case CLI_CUSTOMER:
                provider.deleteCustomerById(parseLong(id)); break;
            case CLI_C_PRODUCT:
                provider.deleteCommonProductById(parseLong(id)); break;
            default:
                throw new IllegalStateException("Unexpected value: " + model.toUpperCase());
        }
        return "";
    }

    private static String getModel(IDataProvider provider, String model, String id) {
        switch (model.toUpperCase()) {
            case CLI_ORDER:
                return provider.getOrderById(parseLong(id)).toString();
            case CLI_DRINK:
                return provider.getDrinkById(parseLong(id)).toString();
            case CLI_CUTLERY:
                return provider.getCutleryById(parseLong(id)).toString();
            case CLI_CUSTOMER:
                return provider.getCustomerById(parseLong(id)).toString();
            case CLI_C_PRODUCT:
                return provider.getCommonProductById(parseLong(id)).toString();
            default:
                throw new IllegalStateException("Unexpected value: " + model.toUpperCase());
        }
    }

    private static String updateModel(IDataProvider provider, String model, String[] s) {
        switch (model.toUpperCase()) {
            case CLI_DRINK:
                return provider.updateDrink(argsToDrink(s)).toString();
            case CLI_CUTLERY:
                return provider.updateCutlery(argsToCutlery(s)).toString();
            case CLI_CUSTOMER:
                return provider.updateCustomer(argsToCustomer(s)).toString();
            case CLI_C_PRODUCT:
                return provider.updateCommonProduct(argsToCommonProduct(s)).toString();
            default:
                throw new IllegalStateException("Unexpected value: " + model.toUpperCase());
        }
    }


    private static Order argsToOrder(IDataProvider provider, String[] s) {
        if (s.length != 4) {
            throw new IllegalStateException(String.format("Current args %d. Need %d", s.length, 7));
        }
        Product product = provider.getProductByTypeAndId(ProductType.valueOf(s[1].toUpperCase()), Long.parseLong(s[2]))
                .orElseThrow(NullPointerException::new);
        Customer customer = provider.getCustomerById(Long.parseLong(s[3])).orElseThrow(NullPointerException::new);
        return new Order(Long.parseLong(s[0]), product, customer);
    }

    private static Drink argsToDrink(String[] s) {
        if (s.length != 7) {
            throw new IllegalStateException(String.format("Current args %d. Need %d", s.length, 7));
        }
        return new Drink(parseLong(s[0]), s[1], Integer.parseInt(s[2]), stringToDate(s[3]), stringToDate(s[4]), Integer.parseInt(s[5]), DrinkType.valueOf(s[6].toUpperCase()));
    }

    private static Cutlery argsToCutlery(String[] s) {
        if (s.length != 6) {
            throw new IllegalStateException(String.format("Current args %d. Need %d", s.length, 6));
        }
        return new Cutlery(parseLong(s[0]), s[1], Integer.parseInt(s[2]), stringToDate(s[3]), stringToDate(s[4]), Integer.parseInt(s[5]));
    }

    private static CommonProduct argsToCommonProduct(String[] s) {
        if (s.length != 7) {
            throw new IllegalStateException(String.format("Current args %d. Need %d", s.length, 7));
        }
        return new CommonProduct(parseLong(s[0]), s[1], Integer.parseInt(s[2]), stringToDate(s[3]), stringToDate(s[4]), Integer.parseInt(s[5]), CommonProductType.valueOf(s[6].toUpperCase()));
    }

    private static Customer argsToCustomer(String[] s) {
        if (s.length != 4) {
            throw new IllegalStateException(String.format("Current args %d. Need %d", s.length, 4));
        }
        return new Customer(parseLong(s[0]), s[1], s[2], Boolean.parseBoolean(s[3]));
    }

    private static Date stringToDate(String s) {
        try {
            return new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).parse(s);
        } catch (ParseException e) {
            return new Date();
        }
    }

    public static String[] removeItem(String[] strings, int index){
        for (int i = index; i < strings.length -1; i++) {
            strings[i] = strings[i + 1];
        }
        return Arrays.copyOf(strings, strings.length - 1);
    }
}