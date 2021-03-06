/*
 * Copyright (c) 2008-2017 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.haulmont.cuba.web.gui.components;

import com.haulmont.bali.util.Preconditions;
import com.haulmont.cuba.gui.components.UrlResource;
import com.vaadin.server.ExternalResource;

import java.net.URL;

public class WebUrlResource extends WebAbstractResource implements WebResource, UrlResource {

    protected URL url;

    protected String mimeType;

    @Override
    public UrlResource setUrl(URL url) {
        Preconditions.checkNotNullArgument(url);

        this.url = url;
        hasSource = true;

        fireResourceUpdateEvent();

        return this;
    }

    @Override
    public URL getUrl() {
        return url;
    }

    @Override
    protected void createResource() {
        resource = new ExternalResource(url);

        ((ExternalResource) resource).setMIMEType(mimeType);
    }

    @Override
    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;

        if (resource != null) {
            ((ExternalResource) resource).setMIMEType(mimeType);
        }
    }

    @Override
    public String getMimeType() {
        return mimeType;
    }
}