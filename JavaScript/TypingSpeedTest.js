const prompt = require('prompt-sync')();
const { performance } = require('perf_hooks');


const sentences = [
    "The sun sets behind the hills of Kano.",
    "Children laugh and run across the dusty road.",
    "A gentle breeze moves through the tall grass.",
    "Books were scattered across the classroom floor.",
    "The old man told stories under the baobab tree.",
    "Markets in the city buzz with life every morning.",
    "Aisha loves reading novels by African authors.",
    "Thunder rumbled as rain started to fall.",
    "Faisal rode his bicycle down the empty street.",
    "Birds chirped loudly in the early morning light."
];


function generateRandomParagraph(count = 3) {
    const paragraph = [];
    for (let i = 0; i < count; i++) {
        const index = Math.floor(Math.random() * sentences.length);
        paragraph.push(sentences[index]);
    }
    return paragraph.join(" ");
}


function calculateAccuracy(original, typed) {
    const minLen = Math.min(original.length, typed.length);
    let correct = 0;
    for (let i = 0; i < minLen; i++) {
        if (original[i] === typed[i]) correct++;
    }
    return (correct / original.length) * 100;
}


const paragraph = generateRandomParagraph();
console.log("\nType the following paragraph as fast and accurately as you can:\n");
console.log(paragraph + "\n");

prompt("Press Enter when you're ready to start typing...");

console.log("\nStart typing now:\n");

const startTime = performance.now();
const userInput = prompt('> ');
const endTime = performance.now();

const timeInSeconds = (endTime - startTime) / 1000;
const timeInMinutes = timeInSeconds / 60;

const wordCount = userInput.trim().split(/\s+/).length;
const wpm = wordCount / timeInMinutes;
const accuracy = calculateAccuracy(paragraph, userInput);

console.log("\n--- Typing Results ---");
console.log(`Time taken: ${timeInSeconds.toFixed(2)} seconds`);
console.log(`Words per Minute (WPM): ${wpm.toFixed(2)}`);
console.log(`Typing Accuracy: ${accuracy.toFixed(2)}%`);
