/**
 * Copyright 2005-2010 Noelios Technologies.
 * 
 * The contents of this file are subject to the terms of one of the following
 * open source licenses: LGPL 3.0 or LGPL 2.1 or CDDL 1.0 or EPL 1.0 (the
 * "Licenses"). You can select the license that you prefer but you may not use
 * this file except in compliance with one of these Licenses.
 * 
 * You can obtain a copy of the LGPL 3.0 license at
 * http://www.opensource.org/licenses/lgpl-3.0.html
 * 
 * You can obtain a copy of the LGPL 2.1 license at
 * http://www.opensource.org/licenses/lgpl-2.1.php
 * 
 * You can obtain a copy of the CDDL 1.0 license at
 * http://www.opensource.org/licenses/cddl1.php
 * 
 * You can obtain a copy of the EPL 1.0 license at
 * http://www.opensource.org/licenses/eclipse-1.0.php
 * 
 * See the Licenses for the specific language governing permissions and
 * limitations under the Licenses.
 * 
 * Alternatively, you can obtain a royalty free commercial license with less
 * limitations, transferable or non-transferable, directly at
 * http://www.noelios.com/products/restlet-engine
 * 
 * Restlet is a registered trademark of Noelios Technologies.
 */

package org.restlet.ext.odata.internal.edm;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Defines a class or type of entity inside a schema. Note that composite keys
 * are not supported.
 * 
 * @author Thierry Boileau
 * @see <a
 *      href="http://msdn.microsoft.com/en-us/library/bb399206.aspx">EntityType
 *      Element (CSDL)</a>
 */
public class EntityType extends NamedObject implements Comparable<EntityType> {

    /** Is this type abstract? */
    private boolean abstractType;

    /** The list of associations. */
    private List<NavigationProperty> associations;

    /** The parent type this type inherits from. */
    private EntityType baseType;

    /** Is this type a blob? */
    private boolean blob;

    /**
     * The entity's member that stores the resource reference able to update the blob value.
     */
    private Property blobValueEditRefProperty;

    /** The property of the entity that stores the blob reference. */
    private Property blobValueRefProperty;

    /** The list of properties that identifies an instance of this type. */
    private List<Property> keys;

    /** The list of properties. */
    private List<Property> properties;

    /** The schema. */
    private Schema schema;

    /**
     * Constructor.
     * 
     * @param name
     *            The name of this entity type.
     */
    public EntityType(String name) {
        super(name);
    }

    /**
     * Compares this object with the specified object for order. The comparison
     * is based on the computed full class name
     */
    public int compareTo(EntityType o) {
        if (o == null) {
            return 1;
        }
        int result = 0;

        String s1 = getFullClassName();
        String s2 = o.getFullClassName();
        if (s1 != null) {
            result = s1.compareTo(s2);
        } else if (s2 != null) {
            result = -1 * s2.compareTo(s1);
        }
        return result;
    }

    /**
     * Returns the list of associations.
     * 
     * @return The list of associations.
     */
    public List<NavigationProperty> getAssociations() {
        if (associations == null) {
            associations = new ArrayList<NavigationProperty>();
        }
        return associations;
    }

    /**
     * Returns the parent type this type inherits from.
     * 
     * @return The parent type this type inherits from.
     */
    public EntityType getBaseType() {
        return baseType;
    }

    /**
     * Returns the entity's member that stores the resource reference able to update the blob value.
     * @return The entity's member that stores the resource reference able to update the blob value.
     */
    public Property getBlobValueEditRefProperty() {
        return blobValueEditRefProperty;
    }

    /**
     * Returns the name of the entity property that stores the blob reference.
     * 
     * @return The name of the entity property that stores the blob reference.
     */
    public Property getBlobValueRefProperty() {
        return blobValueRefProperty;
    }

    /**
     * Returns the Java class name related to this entity type.
     * 
     * @return The Java class name related to this entity type.
     */
    public String getClassName() {
        return getNormalizedName().substring(0, 1).toUpperCase()
                + getNormalizedName().substring(1);
    }

    /**
     * Returns the package name related to this entity type.
     * 
     * @return The package name related to this entity type.
     */
    public String getFullClassName() {
        return Type.getPackageName(getSchema()) + "." + getClassName();
    }

    /**
     * Returns the set of imported entity types.
     * 
     * @return The set of imported entity types.
     */
    public Set<EntityType> getImportedEntityTypes() {
        Set<EntityType> result = new TreeSet<EntityType>();

        for (NavigationProperty property : getAssociations()) {
            result.add(property.getToRole().getType());
        }
        return result;
    }

    /**
     * Returns the set of imported Java classes.
     * 
     * @return The set of imported Java classes.
     */
    public Set<String> getImportedJavaClasses() {
        Set<String> result = new TreeSet<String>();

        for (Property property : getProperties()) {
            if (property.getType().getAdoNetType().endsWith("DateTime")) {
                result.add(property.getType().getJavaClass().getName());
            } else if (property.getType().getAdoNetType().endsWith(
                    "DateTimeOffset")) {
                result.add(property.getType().getJavaClass().getName());
            }
        }

        for (NavigationProperty property : getAssociations()) {
            if (property.getToRole().isToMany()) {
                result.add("java.util.List");
                break;
            }
        }

        return result;
    }

    /**
     * Returns the "keys" property.
     * 
     * @return The "keys" property.
     */
    public List<Property> getKeys() {
        return keys;
    }

    /**
     * Returns the package name related to this entity type.
     * 
     * @return The package name related to this entity type.
     */
    public String getPackageName() {
        return Type.getPackageName(getSchema());
    }

    /**
     * Returns the list of properties.
     * 
     * @return The list of properties.
     */
    public List<Property> getProperties() {
        if (properties == null) {
            properties = new ArrayList<Property>();
        }
        return properties;
    }

    /**
     * Returns the schema.
     * 
     * @return The schema.
     */
    public Schema getSchema() {
        return schema;
    }

    /**
     * Returns true if this type is abstract.
     * 
     * @return True if this type is abstract
     */
    public boolean isAbstractType() {
        return abstractType;
    }

    /**
     * Returns true if this type a blob, that is to say it represents binary
     * data.
     * 
     * @return True if this type a blob, that is to say it represents binary
     *         data.
     */
    public boolean isBlob() {
        return blob;
    }

    /**
     * Indicates if this type is abstract
     * 
     * @param abstractType
     *            True if this type is abstract
     */
    public void setAbstractType(boolean abstractType) {
        this.abstractType = abstractType;
    }

    /**
     * Sets the list of associations.
     * 
     * @param associations
     *            The list of associations.
     */
    public void setAssociations(List<NavigationProperty> associations) {
        this.associations = associations;
    }

    /**
     * Sets the parent type this type inherits from.
     * 
     * @param baseType
     *            The parent type this type inherits from.
     */
    public void setBaseType(EntityType baseType) {
        this.baseType = baseType;
    }

    /**
     * Indicates if this type a blob, that is to say it represents binary data.
     * 
     * @param media
     *            True if this type a blob, that is to say it represents binary
     *            data.
     */
    public void setBlob(boolean blob) {
        this.blob = blob;
    }

    /**
     * Sets the entity's member that stores the resource reference able to update the blob value.
     * @param blobValueEditRefProperty The entity's member that stores the resource reference able to update the blob value.
     */
    public void setBlobValueEditRefProperty(Property blobValueEditRefProperty) {
        this.blobValueEditRefProperty = blobValueEditRefProperty;
    }

    /**
     * Sets the name of the entity property that stores the blob reference.
     * 
     * @param blobValueRefProperty
     *            The name of the entity property that stores the blob
     *            reference.
     */
    public void setBlobValueRefProperty(Property blobValueRefProperty) {
        this.blobValueRefProperty = blobValueRefProperty;
    }

    /**
     * Sets the "keys" property.
     * 
     * @param keys
     *            The "keys" property.
     */
    public void setKeys(List<Property> keys) {
        this.keys = keys;
    }

    /**
     * Sets the list of properties.
     * 
     * @param properties
     *            The list of properties.
     */
    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    /**
     * Sets the schema.
     * 
     * @param schema
     *            The schema.
     */
    public void setSchema(Schema schema) {
        this.schema = schema;
    }
}
