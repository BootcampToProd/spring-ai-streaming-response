# Spring AI - Real-Time Streaming Responses
This repository demonstrates how to build real-time AI applications with **Spring AI Streaming Responses**. The project showcases how to stream data from a Large Language Model (LLM) directly to the client, creating a fluid and interactive user experience similar to modern chatbots.

📖 **Dive Deeper**: For a complete walkthrough, detailed explanations of streaming, Server-Sent Events (SSE), and step-by-step instructions for building this example application, read our comprehensive blog post.<br>
👉 [Spring AI Streaming Response: Build Real-Time AI Apps](https://bootcamptoprod.com/spring-ai-streaming-response-guide/)

🎥 **Visual Learning**: Prefer video tutorials? Watch our step-by-step implementation guide on YouTube.<br>
👉 [Spring AI Streaming Response Tutorial | Build Real-Time AI Apps](https://youtu.be/2AhRVZsxcUM)

---

## 📦 Environment Variables

Make sure to provide these Java environment variables when running the application:

- `GEMINI_API_KEY`: Your Google Gemini API key.

---

## About This Project

This project implements a **Real-Time AI Recipe Planner** as a practical example of Spring AI's streaming capabilities. It showcases how to:

*   Set up a Spring Boot application using **Spring WebFlux** and **Spring AI**.
*   Use the Chat Client to receive continuous data chunks from an AI model.
*   Build two distinct streaming endpoints: one for simple text content and another for rich responses including developer metadata.

The application allows a user to request a recipe for a specific dish, and the AI generates the ingredients and instructions live on screen, piece by piece, instead of making the user wait for the entire response to be completed.

---