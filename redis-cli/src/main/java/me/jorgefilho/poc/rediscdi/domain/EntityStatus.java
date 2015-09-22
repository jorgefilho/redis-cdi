package me.jorgefilho.poc.rediscdi.domain;

import java.io.Serializable;
import java.util.Date;

public class EntityStatus implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private String system;
	
	private String type;
	
	private String typeId;
	
	private String uuid;
	
	private Date  expire;
	
	private Date sendDate;

	public EntityStatus(String system, String type, String typeId, String uuid, Date expire, Date sendDate) {
		this.id = system + type + typeId;
		this.system = system;
		this.type = type;
		this.typeId = typeId;
		this.uuid = uuid;
		this.expire = expire;
		this.sendDate = sendDate;
	}
	
	public String getId() {
		return id;
	}
	
	public String getSystem() {
		return system;
	}
	public String getType() {
		return type;
	}
	public String getTypeId() {
		return typeId;
	}
	public String getUuid() {
		return uuid;
	}
	public Date getExpire() {
		return expire;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public void setExpire(Date expire) {
		this.expire = expire;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((expire == null) ? 0 : expire.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((sendDate == null) ? 0 : sendDate.hashCode());
		result = prime * result + ((system == null) ? 0 : system.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((typeId == null) ? 0 : typeId.hashCode());
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntityStatus other = (EntityStatus) obj;
		if (expire == null) {
			if (other.expire != null)
				return false;
		} else if (!expire.equals(other.expire))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (sendDate == null) {
			if (other.sendDate != null)
				return false;
		} else if (!sendDate.equals(other.sendDate))
			return false;
		if (system == null) {
			if (other.system != null)
				return false;
		} else if (!system.equals(other.system))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (typeId == null) {
			if (other.typeId != null)
				return false;
		} else if (!typeId.equals(other.typeId))
			return false;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EntityStatus [id=" + id + ", system=" + system + ", type=" + type + ", typeId=" + typeId + ", uuid="
				+ uuid + ", expire=" + expire + ", sendDate=" + sendDate + "]";
	}
}
