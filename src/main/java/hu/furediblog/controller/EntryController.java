package hu.furediblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hu.furediblog.dao.model.Authors;
import hu.furediblog.dao.model.Entries;
import hu.furediblog.service.AuthorService;
import hu.furediblog.service.EntryService;


@Controller
public class EntryController{

	Authors author = new Authors();
	Entries entry = new Entries();
	
	
	AuthorService authorService;
	EntryService entryService;
	
	@Autowired
	public void setAuthorService(AuthorService authorService) {
		this.authorService = authorService;
	}

	@Autowired
	public void setEntryService(EntryService entryService) {
		this.entryService = entryService;
	}	
	
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
		model.addAttribute("entries", entryService.listEntries());
		return "stories";
	}
}
