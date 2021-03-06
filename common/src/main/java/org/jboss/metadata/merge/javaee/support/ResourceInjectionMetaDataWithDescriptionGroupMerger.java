/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2013, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.metadata.merge.javaee.support;

import org.jboss.metadata.javaee.spec.DescriptionGroupMetaData;
import org.jboss.metadata.javaee.support.ResourceInjectionMetaDataWithDescriptionGroup;
import org.jboss.metadata.merge.javaee.spec.ResourceInjectionMetaDataMerger;

/**
 * ResourceInjectionMetaData.
 *
 * @author <a href="adrian@jboss.com">Adrian Brock</a>
 * @version $Revision: 1.1 $
 */
public abstract class ResourceInjectionMetaDataWithDescriptionGroupMerger extends ResourceInjectionMetaDataMerger {
    /**
     * The serialVersionUID
     */
    private static final long serialVersionUID = 5085818160192282098L;
    /**
     * The description group
     */
    private DescriptionGroupMetaData descriptionGroup;

    /**
     * Get the descriptionGroup.
     *
     * @return the descriptionGroup.
     */
    public DescriptionGroupMetaData getDescriptionGroup() {
        return descriptionGroup;
    }

    /**
     * Set the descriptionGroup.
     *
     * @param descriptionGroup the descriptionGroup.
     * @throws IllegalArgumentException for a null descriptionGroup
     */
    public void setDescriptionGroup(DescriptionGroupMetaData descriptionGroup) {
        if (descriptionGroup == null)
            throw new IllegalArgumentException("Null descriptionGroup");
        this.descriptionGroup = descriptionGroup;
    }

    public static void merge(ResourceInjectionMetaDataWithDescriptionGroup dest, ResourceInjectionMetaDataWithDescriptionGroup override,
                             ResourceInjectionMetaDataWithDescriptionGroup original) {
        ResourceInjectionMetaDataMerger.merge(dest, override, original);
        if (override != null && override.getDescriptionGroup() != null)
            dest.setDescriptionGroup(override.getDescriptionGroup());
        else if (original != null && original.getDescriptionGroup() != null)
            dest.setDescriptionGroup(original.getDescriptionGroup());
    }

}
