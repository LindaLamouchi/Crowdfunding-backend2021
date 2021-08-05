package crowdfunding.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stripe.Stripe;

@RestController
@RequestMapping(value = "/api")
public class StripeController {
	
	private static void init() {
		Stripe.apiKey = "sk_test_51JKLnqDQsz4BmJ8Q02D0vW2kTcucglIesRvj1HM9B3NjioCcAX6aOHvSEG0vDpJPCTRR77JRkozXD7OXgKNC4VUq00J7neWhOL";
	}
}