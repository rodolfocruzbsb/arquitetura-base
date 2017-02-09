package br.com.zurcs.base.core.entity.util;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.zurcs.commons.util.validators.IsNullUtil;

@XmlRootElement
public class KeyValue implements Serializable {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 5887060456349686414L;

	private Object key;

	private String value;

	public KeyValue() {

	}

	public KeyValue( final Object key, final String value ) {

		this.key = key;
		this.value = value;
	}

	public KeyValue( final Object key, final Object value ) {

		this.key = key;
		this.value = IsNullUtil.isNullOrEmpty(value) ? null : String.valueOf(value);
	}

	public static KeyValue novo(final Object key, final String value) {

		return new KeyValue(key, value);
	}

	public Object getKey() {

		return this.key;
	}

	public void setKey(final Object key) {

		this.key = key;
	}

	public String getValue() {

		return this.value;
	}

	public void setValue(final String value) {

		this.value = value;
	}

	@Override
	public String toString() {

		return "KeyValue [key=" + this.key + ", value=" + this.value + "]";
	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + ( ( this.key == null ) ? 0 : this.key.hashCode() );
		result = prime * result + ( ( this.value == null ) ? 0 : this.value.hashCode() );
		return result;
	}

	@Override
	public boolean equals(final Object obj) {

		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final KeyValue other = (KeyValue) obj;
		if (this.key == null) {
			if (other.key != null) {
				return false;
			}
		} else if (!this.key.equals(other.key)) {
			return false;
		}
		if (this.value == null) {
			if (other.value != null) {
				return false;
			}
		} else if (!this.value.equals(other.value)) {
			return false;
		}
		return true;
	}

}
