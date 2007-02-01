/*
 * Created on Feb 01, 2007
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 * 
 * Copyright @2006 the original author or authors.
 */
package org.testng.jdeveloper.i18n;

import java.text.MessageFormat;

import java.util.Locale;
import java.util.ResourceBundle;

import static org.testng.jdeveloper.util.Objects.isEmpty;

/**
 * Understands internationalization.
 *
 * @author Alex Ruiz
 */
public final class I18N {
  
  private static Locale locale = Locale.getDefault();
  private static ResourceBundle messages = loadMessages();

  private static final String TEXT_KEY_SUFFIX = ".text";
  private static final String MNEMONIC_KEY_SUFFIX = ".mnemonic";
  
  private static ResourceBundle loadMessages() {
    return ResourceBundle.getBundle("messages", locale);
  }
  
  public static String text(String key, Object...args) { 
    String text = messages.getString(textKey(key));
    if (!isEmpty(args)) text = MessageFormat.format(text, args);
    return text; 
  }
  
  public static int mnemonic(String key) { 
    try {
      return Integer.parseInt(messages.getString(mnemonicKey(key)));
    } catch (NumberFormatException e) {
      return 0;
    }
  }

  private static String textKey(String key) { return key + TEXT_KEY_SUFFIX; }
  
  private static String mnemonicKey(String key) { return key + MNEMONIC_KEY_SUFFIX; }
  
  private I18N() {}
}
