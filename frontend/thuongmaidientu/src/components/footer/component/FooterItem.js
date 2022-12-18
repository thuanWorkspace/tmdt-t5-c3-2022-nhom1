import React from "react";

export default function FooterItem({ name, listItem }) {
  return (
    <ul className="mt-16">
      <h3 className="font-medium text-md">{name}</h3>

      {listItem.map((item, index) => (
        <li className="mt-4 cursor-pointer" key={index}>
          {item}
        </li>
      ))}
    </ul>
  );
}
