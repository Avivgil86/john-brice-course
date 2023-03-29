package app.core.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ExampleSentence {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String example;

	@JsonIgnore
	@ManyToOne
	@JoinColumn
	private EntryWord entryWord;

	public ExampleSentence() {

	}

	public ExampleSentence(int id, String example, EntryWord entryWord) {
		super();
		this.id = id;
		this.example = example;
		this.entryWord = entryWord;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getExample() {
		return example;
	}

	public void setExample(String example) {
		this.example = example;
	}

	public EntryWord getEntryWord() {
		return entryWord;
	}

	public void setEntryWord(EntryWord entryWord) {
		this.entryWord = entryWord;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExampleSentence other = (ExampleSentence) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "ExampleSentence [id=" + id + ", example=" + example + "]";
	}

}
