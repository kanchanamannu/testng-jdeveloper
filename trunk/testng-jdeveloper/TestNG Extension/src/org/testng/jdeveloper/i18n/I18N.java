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
 * Understands internationalization. Messages are stored in the file messages.properties. 
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
  
  /**
   * Returns (from the file messages.properties) a message given its key.
   * @param key the key to be used to find the message.
   * @param args any arguments to be used to format the message to return.
   * @return a message given its key.
   */
  public static String text(String key, Object...args) { 
    String text = messages.getString(keyForText(key));
    if (!isEmpty(args)) return MessageFormat.format(text, args);
    return text; 
  }

  /**
   * Returns (from the file messages.properties) a number representing the mnemonic to use in a GUI component.
   * @param key the key to be used to find the mnemonic.
   * @return a number representing the mnemonic to use in a GUI component.
   */
  public static int mnemonic(String key) { 
    try {
      return Integer.parseInt(messages.getString(keyForMnemonic(key)));
    } catch (NumberFormatException e) {
      return 0;
    }
  }

  private static String keyForText(String key) { return key + TEXT_KEY_SUFFIX; }
  private static String keyForMnemonic(String key) { return key + MNEMONIC_KEY_SUFFIX; }
  
  private I18N() {}
}
