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
package org.testng.jdeveloper;

import javax.swing.JMenuItem;

import oracle.ide.Addin;
import oracle.ide.Context;
import oracle.ide.controller.ContextMenu;
import oracle.ide.controller.ContextMenuListener;
import oracle.ide.controller.IdeAction;
import static oracle.ide.explorer.ExplorerManager.getExplorerManager;
import oracle.ide.model.Attributes;
import oracle.ide.model.Element;
import oracle.ide.model.Node;

import oracle.jdevimpl.java.explorer.JavaCodeElement;
import oracle.jdevimpl.java.explorer.MethodElement;

/**
 * Understands the entry point of the TestNG extension.
 * 
 * @author Alex Ruiz
 */
public final class TestNGAddin implements Addin {

  public void initialize() {
    addContextMenuToExplorerManager();
  }

  private void addContextMenuToExplorerManager() {
    ContextMenu contextMenu = getExplorerManager().getContextMenu();
    contextMenu.addContextMenuListener(new AbstractContextMenuListener() {
      @Override public void menuWillShow(ContextMenu contextMenu) {
        Context context = contextMenu.getContext();
        Element e = context.getElement();
        if (!isTestMethod(e)) return;
    //        IdeAction myAction = IdeAction.find(_myActionID);
    //        JMenuItem myMenu = contextMenu.createMenuItem(myAction);
    //        contextMenu.add(myMenu);
      }
    });
  }

  private boolean isTestMethod(Element e) {
    if (!(e instanceof MethodElement)) return false;
    MethodElement methodElement = (MethodElement)e;
    return true;
  }
}
