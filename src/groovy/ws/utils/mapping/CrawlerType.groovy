package ws.utils.mapping

/**
 * Zadcor created this package on
 * 2/19/14, copyright is reserved with zadcor
 */
class CrawlerType extends AbstractType {
    public static final String NAME="Crawler"
    public static final String LINK="link"
    public static final String ADDED_ON="AddedOn"
    public static final String SEARCHON=LINK+".raw"

    @Override
    void setFieldToSearch() {
        FIELDSTOFETCH=[LINK,ADDED_ON]
    }
}
