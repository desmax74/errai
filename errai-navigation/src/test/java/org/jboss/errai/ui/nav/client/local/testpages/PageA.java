/*
 * Copyright (C) 2015 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jboss.errai.ui.nav.client.local.testpages;

import javax.enterprise.context.ApplicationScoped;

import org.jboss.errai.ui.nav.client.local.DefaultPage;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.nav.client.local.PageShowing;

import com.google.gwt.user.client.ui.SimplePanel;

@ApplicationScoped
@Page(role = DefaultPage.class)
public class PageA extends SimplePanel {

  private int beforeShowCallCount;
  private boolean[] initStateHolder;
  private boolean initStateWhenBeforeShowWasCalled;

  public int getBeforeShowCallCount() {
    return beforeShowCallCount;
  }

  public boolean[] getInitStateHolder() {
    return initStateHolder;
  }

  public boolean isInitStateWhenBeforeShowWasCalled() {
    return initStateWhenBeforeShowWasCalled;
  }

  @PageShowing
  private void beforeShow() {
    beforeShowCallCount++;
    initStateWhenBeforeShowWasCalled = initStateHolder == null ? false : initStateHolder[0];
  }

  public void setInitStateHolder(boolean[] initStateHolder) {
    this.initStateHolder = initStateHolder;
  }

}
