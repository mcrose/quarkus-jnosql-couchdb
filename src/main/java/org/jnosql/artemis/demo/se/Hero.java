/*
 * Copyright (c) 2017 Otávio Santana and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Apache License v2.0 which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Apache License v2.0 is available at http://www.opensource.org/licenses/apache2.0.php.
 *
 * You may elect to redistribute this code under either of these licenses.
 *
 * Contributors:
 *
 * Otavio Santana
 */
package org.jnosql.artemis.demo.se;

import java.io.Serializable;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

import org.jnosql.artemis.Column;
import org.jnosql.artemis.Entity;
import org.jnosql.artemis.Id;
import org.jnosql.artemis.demo.se.HeroBuilder;

@Entity
public class Hero implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Column
    private String name;

    @Column
    private String realName;

    @Column
    private Integer age;

    @Column
    private Set<String> powers;

    Hero() {
    }

    Hero(String name, String realName, Integer age, Set<String> powers) {
        this.id = name;
        this.name = name;
        this.realName = realName;
        this.age = age;
        this.powers = powers;
    }

    public String getName() {
        return name;
    }

    public String getRealName() {
        return realName;
    }

    public Integer getAge() {
        return age;
    }

    public Set<String> getPowers() {
        if (powers == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(powers);
    }

    public static HeroBuilder builder() {
        return new HeroBuilder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Hero)) {
            return false;
        }
        Hero hero = (Hero) o;
        return Objects.equals(name, hero.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Hero{");
        sb.append("name='").append(name).append('\'');
        sb.append(", realName='").append(realName).append('\'');
        sb.append(", age=").append(age);
        sb.append(", powers=").append(powers);
        sb.append('}');
        return sb.toString();
    }
}