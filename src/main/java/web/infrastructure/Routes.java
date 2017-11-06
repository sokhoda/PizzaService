package web.infrastructure;

public class Routes {
    //    dashboard
    public static final String REDIRECT_DASHBOARD_PAGE = "redirect:../dashboard";

    //    order
    public static final String ORDER_EDIT_PAGE = "/order/orderedit";
    public static final String ORDER_CREATE = "/order/create";
    public static final String ORDER_ADDNEW = "/order/addnew";

    //    pizza

    //    customer
    public static final String CUSTOMER_EDIT_PAGE = "customer/customeredit";
    public static final String REDIRECT_CUSTOMER_LIST_PAGE = "redirect:../customer/list";
    public static final String CUSTOMER_LIST_PAGE = "customer/customerlist";
    public static final String CUSTOMER_CREATE = "/customer/create";
    public static final String CUSTOMER_EDIT = "/customer/edit";
    public static final String CUSTOMER_ADD_NEW = "/customer/addnew";
    public static final String CUSTOMER_CUSTOMERLIST_UPLOAD = "/customer/customerlist/upload";
    public static final String CUSTOMER_REMOVE = "/customer/remove";
    public static final String CUSTOMER_LIST = "/customer/list";
    //    utils
    public static final String UTILS_UPLOAD_CUSTOMER_LIST_PAGE = "utils/upload/customerListUpload";
}
