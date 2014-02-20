package ws.utils.mapping

/**
 * Zadcor created this package on
 * 2/19/14, copyright is reserved with zadcor
 */
abstract class AbstractType {
    static  String[] FIELDSTOFETCH;
    public  abstract void setFieldToSearch();

    public  String[] getFIELDSTOFETCH() {
        return FIELDSTOFETCH
    }
}
