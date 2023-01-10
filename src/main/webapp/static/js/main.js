/**
 * This file is for checking in/searching for a topic 
 */
// StackExchange and MDN api urls
let stackExchangeQuery = "https://api.stackexchange.com/2.3/search?order=desc&sort=activity&site=stackoverflow&tagged=";
let mdnQuery = "https://developer.mozilla.org/en-US/search.json?locale=en-US&q=";

// Dom elements
const chatBtn = document.querySelector(".chat-btn");
const checkinForm = document.querySelector("#check-in-form");
const possobleSolutionsContainer = document.querySelector('.possible-solutions');
const yourStatusContainer = document.querySelector('.your-status');

// User role (Student or Mentor)
let role = "";

// Fetch topics from Stackoverflow
const fetchResourceFromStackOverFlow = async(url) => {
	const result = await fetch(url);
	const res = await result.json();
	return res;	
}

// Fetch topics from mdn
const fetchResourceFromMdn = async(url) => {
	const result = await fetch(url);
	const res = await result.json();
	console.log(res);
	return res;
}

// Refresh the page to search for a new topic
const refreshPage = () => {
	window.location.href = window.location.href;
}

// Generate HTML for fetched data from Stackoverflow
const generateHtmlForStackOverflowSearchQuery = (items) => {
	const newQuestionBtn = document.createElement('button');
	newQuestionBtn.className = 'new-question btn btn-warning float-right mb-3';
	newQuestionBtn.innerText = 'New Question';
	newQuestionBtn.addEventListener('click', refreshPage);
	
	const title = document.createElement('h2');
	title.innerText = 'Possible Solutions';
	title.className = 'sub-title mb-3';
	
	const solutionsContainer = document.createElement('div');
	solutionsContainer.classList.add('possible-solutions');
	
	solutionsContainer.appendChild(newQuestionBtn);
	solutionsContainer.appendChild(title);
	
	items.forEach(item => {
		const solutionsDetials = document.createElement('div');
		solutionsDetials.className = 'bg-body border border-gray shadow-lg roudned p-3';
		
		const title = document.createElement('h3');
		title.innerText = item.title;
		
		const link = document.createElement('a');
		link.href = item.link;
		link.target = '_blank';
		link.innerText = item.title;
		
		const score = document.createElement('p');
		score.innerText = "Ratting: " + item.score;
		
		solutionsDetials.appendChild(title);
		solutionsDetials.appendChild(link);
		solutionsDetials.appendChild(score);
		
		solutionsContainer.appendChild(solutionsDetials);
	});
	
	possobleSolutionsContainer.replaceChildren(solutionsContainer);
}

// Generate HTML form MDN Query
const generateHtmlForMdnQuery = (items) => {
	
}


// Event Listener for checkin form
checkinForm.addEventListener('submit', async (e) => {
	e.preventDefault();
	const formData = new FormData(checkinForm);
	const query = formData.get('topic');
	const tags = formData.get('tags');
	role = formData.get('role');
	const username = formData.get('username');
	
	// Create/update user status
	const p = document.createElement('p');
	p.innerText = username + " " + role;
	yourStatusContainer.appendChild(p);

	stackExchangeQuery +=  tags + '&intitle=' + query;
	
	const res = await fetchResourceFromStackOverFlow(stackExchangeQuery);
	
	generateHtmlForStackOverflowSearchQuery(res.items);
	mdnQuery =  "https://cors-anywhere.herokuapp.com/" + mdnQuery;
	mdnQuery += tags;
	fetchResourceFromMdn(mdnQuery);
	
	console.log(res);
});
