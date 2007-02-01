/*
 * Created on Nov 22, 2006
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
package org.testng.jdeveloper.extension;

import javax.swing.Icon;
import javax.swing.JMenuItem;

import static oracle.ide.AddinManager.getAddinManager;
import oracle.ide.Context;
import static oracle.ide.Ide.findOrCreateCmdID;
import static oracle.ide.Ide.getMenubar;
import static oracle.ide.ceditor.CodeMenuConstants.CATEGORY_CODE_MENU;
import oracle.ide.controller.ContextMenu;
import oracle.ide.controller.IdeAction;
import oracle.ide.explorer.ExplorerWindow;
import oracle.ide.model.Element;
import oracle.ide.view.View;

import oracle.jdevimpl.java.explorer.ModifierElement;

import org.testng.jdeveloper.i18n.I18N;


/**
 * Adds TestNG-related context listeners to the pop-up menus shown in the "Code Editor" or the "Structure" window.
 * 
 * @author Alex Ruiz
 */
final class AddinContextListener extends AbstractContextMenuListener {

  /** Name of this Addin */
  static final String ADDIN_NAME = "TestNGAddin";

  /** The Id for the "Run As TestNG Test" command. */
  static final int RUN_AS_TEST_CMD_ID = findOrCreateCmdID(ADDIN_NAME + ".RUN_TESTNG_TEST_CMD");

  private boolean menuItemsCreated;
  private IdeAction runAsTestAction;
  private JMenuItem runAsTestMenuItem;
  
  @Override public void menuWillShow(ContextMenu contextMenu) {
    Context context = validContextFrom(contextMenu);
    if (context == null) return;
    createMenuItems();
    View view = context.getView();
    Element e = context.getElement();
    if (view instanceof ExplorerWindow && e instanceof ModifierElement) {
    }
  }
  
  private Context validContextFrom(ContextMenu contextMenu) {
    if (contextMenu == null) return null;
    Context context = contextMenu.getContext();
    return isValid(context) ? context : null;
  }
  
  private boolean isValid(Context context) {
     return context != null || context.getSelection().length == 1 || context.getProject() != null;
  }
  
  private void createMenuItems() {
    if (menuItemsCreated) return;
    createRunAsTestMenuItem();
    menuItemsCreated = true;
  }
  
  private void createRunAsTestMenuItem() {
    runAsTestAction = createNewAction(RUN_AS_TEST_CMD_ID, "menu.runAsTest", null);
    runAsTestMenuItem = getMenubar().createMenuItem(runAsTestAction);
  }

  private IdeAction createNewAction(int commandId, String i18nKey, Icon icon) {
    String commandClass = getAddinManager().getCommand(commandId, null);
    String label = I18N.text(i18nKey);
    int mnemonic = I18N.mnemonic(i18nKey);
    return IdeAction.get(commandId, commandClass, label, CATEGORY_CODE_MENU, mnemonic, icon, null, false);
  }
}
