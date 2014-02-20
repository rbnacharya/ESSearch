package ws.utils.response

import ws.utils.mapping.AbstractType
import ws.utils.mapping.CrawlerType

/**
 * Created By: racharya
 * Date: 2/19/14 : 2:12 PM
 */
public class CountResponse extends DefaultFieldResponse{
    @Override
    AbstractType getESType() {
        return new CrawlerType()
    }
}
