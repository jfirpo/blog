package hu.furediblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hu.furediblog.service.AuthorService;
import hu.furediblog.service.EntryService;


@Controller
public class EntryController{

	// delete ahogy az authoroknal pipa
	//Authors author = new Authors();
	//Entries entry = new Entries();
	
	
	AuthorService authorService;
	EntryService entryService;
	
	@Autowired(required=true)
	@Qualifier(value="authorService")
	public void setAuthorService(AuthorService authorService) {
		this.authorService = authorService;
	}

	@Autowired(required=true)
	@Qualifier(value="entryService")
	public void setEntryService(EntryService entryService) {
		this.entryService = entryService;
	}	
	
	@RequestMapping(value = "/addEntry", method = RequestMethod.GET)
	public String addEntryBox(int id, Model model) {				
		model.addAttribute("author", authorService.getAuthorById(id));
		return "addstory";
	}


	// redirect - pipa
	@RequestMapping(value = "/addEntryToDb", method = RequestMethod.POST)
	public ModelAndView addEntryToDb(int author, String content, Model model) {										
		entryService.addEntry(authorService.getAuthorById(author), content);
		model.addAttribute("entries", entryService.listEntries());
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/stories", method = RequestMethod.GET)
	public String getStories(Model model) {		
		model.addAttribute("entries", entryService.listEntries());	
		return "stories";
	}
	
//	@RequestMapping(value = "/stories", method = RequestMethod.GET)
//	public String getStories(Model model) {
//		model.addAttribute("entries", entryService.listEntries());
//		return "stories";
//	}	
}
