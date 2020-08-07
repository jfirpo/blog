package hu.furediblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hu.furediblog.dao.model.Authors;
import hu.furediblog.dao.model.Entries;


@Controller
public class EntryController extends AbstractController {
	
	
	@RequestMapping(path = "/addEntryBox", method = RequestMethod.GET)
	public String addEntryBox(int id, Model model) {
		author = blogService.getAuthorRepo().findById(id);
		model.addAttribute("author", author);
		return addstory(model);
	}

	@RequestMapping(path = "/addEntryToDb", method = RequestMethod.POST)
	public String addEntryToDb(int id, String content, Model model) {
		author = new Authors();

		entry.setAuthor(id);
		entry.setContent(content);
		blogService.getEntryRepo().save(entry);
		author = new Authors();
		entry = new Entries();
		return getStories(model);
	}

	@RequestMapping(path = "/stories", method = RequestMethod.GET)
	public String getStories(Model model) {
		model.addAttribute("entries", blogService.getEntries());
		return "stories";
	}
	
	
	@RequestMapping(path = "/addstory", method = RequestMethod.GET)
	public String addstory(Model model) {
		model.addAttribute("author", author);
		return "addstory";
	}

}
