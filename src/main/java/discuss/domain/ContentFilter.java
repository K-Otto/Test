package discuss.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by student on 2015/06/03.
 */
@Embeddable
public class ContentFilter implements Serializable {
    private String contentCheck;


    private ContentFilter() {
    }

    public ContentFilter(Builder builder) {
        contentCheck=builder.contentCheck;

    }

    public String getContentCheck() {
        return contentCheck;
    }


    public static class Builder{
        private String contentCheck;


        public Builder(String contentCheck) {
            this.contentCheck = contentCheck;
        }



        public Builder copy(ContentFilter value){

            this.contentCheck=value.contentCheck;
            return this;
        }

        public ContentFilter build(){
            return new ContentFilter(this);
        }
    }

}
