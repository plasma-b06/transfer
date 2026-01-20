const readlineSync = require('readline-sync');

const userName = readlineSync.question('May I know your name? ');
console.log(`Welcome, ${userName}!`);

const userAge = readlineSync.question('May I know your age? ');

const userAgeNumber = Number(userAge);

if (!isNaN(userAgeNumber)){
	if (userAgeNumber > 121 || userAgeNumber < 0){
		console.log("enter valid age");
		return -1;
	}
}

if (!isNaN(userAgeNumber)) {
    const currentYear = new Date().getFullYear();
    const birthYear = currentYear - userAgeNumber;
    console.log(`You were born in the year ${birthYear}.`);
} else {
    console.log('Please enter a valid number for age.');
}
