package ws.utils.response

import ws.utils.mapping.AbstractType
import ws.utils.mapping.SearchESType

/**
 * Created By: racharya
 * Date: 2/19/14 : 10:32 AM
 */
public class QSearchResponse extends DefaultFieldResponse {
    @Override
    AbstractType getESType() {
        return new SearchESType()
    }
}
