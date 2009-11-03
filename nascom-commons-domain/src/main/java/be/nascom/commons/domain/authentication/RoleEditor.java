package be.nascom.commons.domain.authentication;

import java.beans.PropertyEditorSupport;

/**
 * User: bart
 * Date: May 18, 2009
 * Time: 3:24:32 PM
 */
public class RoleEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String value) {
        setValue(new Role(Long.parseLong(value)));
    }

    @Override
    public String getAsText() {
        if (getValue() instanceof Role) {
            return Long.toString(((Role) getValue()).getId());
        }
        return null;
    }
}
