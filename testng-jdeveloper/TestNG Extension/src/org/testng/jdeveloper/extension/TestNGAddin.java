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

import oracle.ide.Addin;
import static oracle.ide.Ide.findOrCreateCmdID;
import oracle.ide.controller.ContextMenu;
import static oracle.ide.explorer.ExplorerManager.getExplorerManager;

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
    contextMenu.addContextMenuListener(new AddinContextListener());
  }

}
