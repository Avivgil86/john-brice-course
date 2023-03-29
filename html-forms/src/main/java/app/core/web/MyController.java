package app.core.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {
	public enum NatoAlphabet {
		ALPHA, BRAVO, CHARLIE, DELTA, ECHO, FOXTROT, GOLF, HOTEL, INDIA, JULIETT, KILO, LIMA, MIKE, NOVEMBER, OSCAR,
		PAPA, QUEBEC, ROMEO, SIERRA, TANGO, UNIFORM, VICTOR, WHISKEY, X_RAY, YANKEE, ZULU;

		public static NatoAlphabet getChar(Character character) {
			character = Character.toUpperCase(character);
			NatoAlphabet[] arr = NatoAlphabet.values();
			int index = character - 'A';
			return arr[index];
		}

		public static String AlphaBetaConvertReturn(String text) {
			String msgString = "";
			for (char c : text.toCharArray()) {
				if (c == ' ') {
					msgString += " SPACE- ";
				} else {
					msgString += getChar(c) + " - ";
				}
			}

			return msgString;
		}
	}

	@GetMapping("/random-char")
	public NatoAlphabet getRandomChar() {
		NatoAlphabet[] arr = NatoAlphabet.values();
		return arr[(int) (Math.random() * arr.length)];

	}

	@GetMapping("/by-char")
	public NatoAlphabet getChar(@RequestParam("char") Character tav) {
		return NatoAlphabet.getChar(tav);
	}

	@GetMapping("/by-one-char")
	public NatoAlphabet AlphaBetaOneCharReturn(Character tav) {
		NatoAlphabet[] arr = NatoAlphabet.values();
		tav = Character.toUpperCase(tav);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].name().charAt(0) == tav) {
				return arr[i];
			}
		}
		return null;
	}

	@GetMapping("/convert")
	public String AlphaBetaConvertReturn(String text) {
		return NatoAlphabet.AlphaBetaConvertReturn(text);
	}
	@GetMapping("/hobbies")
	public String sentHobbies(@RequestParam("fav-color") String favoritColor, String... hobbies) {
	String responseString = "Your hobbies are: <ul>";
		for (String hobby : hobbies) {
			System.out.println(hobby);
			responseString +="<li>" + hobby + "</li>";
		}
		responseString +="</ul>";
		
		responseString +="favorite color " + favoritColor;
		return responseString;
	}
}
