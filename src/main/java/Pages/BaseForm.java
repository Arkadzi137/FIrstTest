package Pages;

import Framework.Elements.BaseElement;
import Framework.Log;

abstract public class BaseForm {
    protected BaseElement element;
    protected String name;

    public BaseForm(BaseElement element,String name){
        this.name = name;
        this.element = element;
    }
    public boolean isOpen() {
        Log.info(name + " opened" );
        return element.isVisible();
    }

}
