import time
import random


sentences = [
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
]

def generate_random_paragraph(n=3):
    return ' '.join(random.sample(sentences, n))

def calculate_accuracy(original, typed):
    correct = 0
    min_len = min(len(original), len(typed))
    for i in range(min_len):
        if original[i] == typed[i]:
            correct += 1
    return (correct / len(original)) * 100

def typing_speed_test():
    paragraph = generate_random_paragraph()
    print("\nType the following paragraph as fast and accurately as you can:\n")
    print(paragraph)
    input("\nPress Enter when you're ready to start typing...")

    print("\nStart typing below:\n")
    start_time = time.time()
    typed_input = input("> ")
    end_time = time.time()

    time_taken = end_time - start_time
    time_in_minutes = time_taken / 60
    word_count = len(typed_input.strip().split())
    wpm = word_count / time_in_minutes
    accuracy = calculate_accuracy(paragraph, typed_input)

    print("\n--- Typing Results ---")
    print(f"Time taken: {time_taken:.2f} seconds")
    print(f"Words Per Minute (WPM): {wpm:.2f}")
    print(f"Typing Accuracy: {accuracy:.2f}%")

typing_speed_test()
