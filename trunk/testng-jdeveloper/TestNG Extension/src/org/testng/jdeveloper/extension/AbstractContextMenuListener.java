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

import oracle.ide.Context;
import oracle.ide.controller.ContextMenu;
import oracle.ide.controller.ContextMenuListener;

/**
 * Understands a template for implementations of <code>{@link ContextMenuListener}</code>. It allows extensions to add 
 * menu items and submenus to the context menu.
 * 
 * @author Alex Ruiz
 */
abstract class AbstractContextMenuListener implements ContextMenuListener {

  /**
   * Called just before the context menu is shown. Implementations should add their items to the context menu here.
   * @param contextMenu the context menu to be shown.
   */
  public void menuWillShow(ContextMenu contextMenu) {}

  /**
   * This method is called just before a context menu is dismissed. Most implementations should not do anything in this 
   * method. In particular, it is not necessary to clean out menu items or submenus that were added during 
   * <code>{@link #menuWillShow(ContextMenu)}</code>, since the IDE takes care of that automatically.
   * @param contextMenu the context menu to be hidden.
   */
  public void menuWillHide(ContextMenu contextMenu) {}

  /**
   * Called when the user double clicks on an item that has a context menu. If the listener handles the action, then it 
   * must return <code>true</code>; otherwise it must return <code>false</code>. Processing of 
   * <code>{@link #handleDefaultAction(Context)}</code> stops on the first return of <code>true</code>.
   * @param context the context on which the default action needs to occur.
   * @return <code>false</code>.
   */
  public boolean handleDefaultAction(Context context) { return false; }
}
