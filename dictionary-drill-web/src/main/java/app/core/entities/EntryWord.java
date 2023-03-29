package app.core.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "entries")
public class EntryWord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String word;
	private String definition;

//	@JsonIgnore
	@OneToMany(mappedBy = "entryWord", cascade = CascadeType.ALL)
	private List<ExampleSentence> sentences;

	public EntryWord() {

	}

	public EntryWord(int id, String word, String definition, List<ExampleSentence> sentences) {
		super();
		this.id = id;
		this.word = word;
		this.definition = definition;
		this.sentences = sentences;
		if (sentences != null) {
			for (ExampleSentence exampleSentence : this.sentences) {
				exampleSentence.setEntryWord(this); // bind the example with the word
			}
		}
	}

	public void addExampleSentence(ExampleSentence exampleSentence) {
		if (this.sentences == null) {
			this.sentences = new ArrayList<>();
		}
		exampleSentence.setEntryWord(this); // bind the example with the word
		this.sentences.add(exampleSentence);
	}

//	public void setSenteces(List<ExampleSentence> sentences) {
	public void setSentences(List<ExampleSentence> sentences) {
		for (ExampleSentence exampleSentence : sentences) {
			exampleSentence.setEntryWord(this); // bind the example with the word
		}
		this.sentences = sentences;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public List<ExampleSentence> getSentences() {
		return sentences;
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
		EntryWord other = (EntryWord) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "EntryWord [id=" + id + ", word=" + word + ", definition=" + definition + "]";
	}

}
