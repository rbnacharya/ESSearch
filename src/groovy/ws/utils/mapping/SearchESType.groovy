package ws.utils.mapping

/**
 * Zadcor created this package on
 * 2/19/14, copyright is reserved with zadcor
 */
class SearchESType extends AbstractType{
    public static final String NAME="Search"
    public static final String LINK="link"
    public static final String TITLE="title"
    public static final String BODY="body"
    public static final String EXCERPT="excerpt"


    @Override
    void setFieldToSearch() {
        FIELDSTOFETCH=[LINK,TITLE,BODY]
    }
}
