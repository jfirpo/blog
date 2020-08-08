package hu.furediblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class EntryController extends AbstractController {
		
	@RequestMapping(path = "/addEntryBox", method = RequestMethod.GET)
	public String addEntryBox(int id, Model model) {				
		model.addAttribute("author", authorService.getAuthorById(id));
		return "addstory";
	}

	@RequestMapping(path = "/addEntryToDb", method = RequestMethod.POST)
	public String addEntryToDb(int id, String content, Model model) {										
		entryService.addEntry(id, content);		
		return getStories(model);
	}

	@RequestMapping(path = "/stories", method = RequestMethod.GET)
	public String getStories(Model model) {
		model.addAttribute("entries", blogService.getEntries());
		return "stories";
	}
}
