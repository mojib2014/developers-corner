/**
 * 
 */
// Active nav links
document.querySelectorAll('header ul li a').forEach(ele => ele.href === window.location.href ? ele.classList.add('active') : null);
