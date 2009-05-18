package be.nascom.commons.domain.authentication;

import java.beans.PropertyEditorSupport;
import java.util.StringTokenizer;

/**
 * User: bart
 * Date: May 18, 2009
 * Time: 3:24:32 PM
 */
public class RoleEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String value) {
        StringTokenizer t = new StringTokenizer(value, ";");
        setValue(new Role(Integer.parseInt(t.nextToken()), t.nextToken()));
    }
}
