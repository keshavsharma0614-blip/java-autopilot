package com.jatp.automation.drivers;

import com.jatp.core.model.Widget;
import java.util.logging.Logger;

/**
 * Mock Driver for SWTBot automation to allow the MVP build to compile.
 */
public class SwtBotDriver {
    private static final Logger logger = Logger.getLogger(SwtBotDriver.class.getName());

    public boolean clickButton(Widget widget) {
        logger.info("[MockSwtBot] Clicking button: " + widget.label());
        return true;
    }

    public boolean enterText(Widget widget, String text) {
        logger.info("[MockSwtBot] Entering text '" + text + "' into: " + widget.label());
        return true;
    }
}
